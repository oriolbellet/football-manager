pipeline {

    environment {
        REGISTRY = "oriolbellet/football"
        REGISTRY_CREDENTIAL = 'dockerhub'
        DOCKER_IMAGE = ''
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
                    DOCKER_IMAGE = docker.build REGISTRY + ":$BUILD_NUMBER"
                }
            }
        }

        stage('Deploying docker') {
            when { branch 'master' }
            steps {
                script {
                    docker.withRegistry( '', REGISTRY_CREDENTIAL ) {
                        DOCKER_IMAGE.push()
                        DOCKER_IMAGE.push('latest')
                    }
                }
            }
        }
        
        stage('Deploy to GKE') {
            when { branch 'master' }
            steps{
                sh "sed -i 's/football:latest/football:${env.BUILD_ID}/g' deployment.yml"
                step([$class: 'KubernetesEngineBuilder', projectId: env.PROJECT_ID, clusterName: env.CLUSTER_NAME, location: env.LOCATION, manifestPattern: 'deployment.yml', credentialsId: env.CREDENTIALS_ID, verifyDeployments: true])
            }
        }

        stage('Cleaning up docker') {
            when { branch 'master' }
            steps{
                sh "docker rmi $REGISTRY:$BUILD_NUMBER"
            }
        }
       
    }
}
