## Deploy Jenkis to AWS EKS with Helm & Ansible tutorial

This tutorial show how easily we can deploy Jenkins Helm chart into AWS EKS with Ansible.


## Prerequisites

Before beginning this tutorial, you should have the following:

- AWS EKS cluster with at least one worker node
- IAM admin role for accessing the cluster and launching jobs
- Ansible binary >=2.13.6
- Helm binary >=3.8.2

This tutorial will not use any Ansible remote server. All Ansible connections will be **local** only.


## Setting up 

Modify `group_vars/all.yml` in order to match your desired state.
See [Official Jenkins Helm chart](https://github.com/jenkinsci/helm-charts/tree/main/charts/jenkins) for detailed description about chart values.

In this tutorial we are using L7 **AWS EKS Application Load Balancer** and **ExternalDNS** addons, thus we have to customize ingress config individually. See more details in [AWS-Load-Balancer-Controller docs](https://kubernetes-sigs.github.io/aws-load-balancer-controller/v2.2/guide/ingress/annotations/#ssl).


## Running

```ansible-playbook jenkins.yml -i path_to_your_inventory```

## Conclusion

Congratulations! You have successfully set up Jenkins with Ansible and Helm. You can now use Jenkins to automate the deployment of your infrastructure and applications with EKS cluster.