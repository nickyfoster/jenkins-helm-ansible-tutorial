import hudson.plugins.git.*
import org.jenkinsci.plugins.workflow.cps.*
import org.jenkinsci.plugins.workflow.job.*

def instance = Jenkins.getInstance()

def pipelineGitUrl = "{{ pipeline_git_url }}"
def pipelineGitBranch = "{{ pipeline_git_branch }}"
def pipelineGitCredsId = "{{ pipeline_git_creds }}"
def pipelineName = "{{ pipeline_name }}"

def pipelineScm = new GitSCM(
    GitSCM.createRepoList(pipelineGitUrl, pipelineGitCredsId),
    [new BranchSpec(pipelineGitBranch)],
    false,
    [],
    null,
    null,
    []
)

def pipelineJenkinsfilePath = "{{ pipeline_jenkinsfile_path }}"
def pipelineDefinition = new CpsScmFlowDefinition(pipelineScm, pipelineJenkinsfilePath)
pipelineDefinition.setLightweight(true)

def pipelineJob = new WorkflowJob(instance, pipelineName)
pipelineJob.setDefinition(pipelineDefinition)