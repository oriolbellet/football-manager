pipeline {

    environment {
        registry = "oriolbellet/football"
        registryCredential = 'dockerhub'
        dockerImage = ''
        PROJECT_ID = 'king-oriolbellet-sandbox'
        CLUSTER_NAME = 'multi-cluster'
        LOCATION = 'us-central1-c'
        CREDENTIALS_ID = 'football'
    }

    agent any

    tools {
        maven 'jenkins-maven'
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Building docker') {
            when { branch 'master' }
            steps{
                script {
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }

        stage('Deploying docker') {
            when { branch 'master' }
            steps {
                script {
                    docker.withRegistry( '', registryCredential ) {
                        dockerImage.push()
                        dockerImage.push('latest')
                    }
                }
            }
        }
        
        stage('Deploy to GKE') {
            steps{
                step([$class: 'KubernetesEngineBuilder', projectId: env.PROJECT_ID, clusterName: env.CLUSTER_NAME, location: env.LOCATION, manifestPattern: 'deployment.yml', credentialsId: env.CREDENTIALS_ID, verifyDeployments: true])
            }
        }

        stage('Cleaning up docker') {
            when { branch 'master' }
            steps{
                sh "docker rmi $registry:$BUILD_NUMBER"
            }
        }
       
    }
}
