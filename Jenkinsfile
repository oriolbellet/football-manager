pipeline {

    environment {
        registry = "oriolbellet/football"
        registryCredential = 'dockerhub'
        dockerImage = ''
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

        stage('Cleaning up docker') {
            when { branch 'master' }
            steps{
                sh "docker rmi $registry:$BUILD_NUMBER"
            }
        }
    }
}