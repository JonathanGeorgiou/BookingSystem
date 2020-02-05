pipeline {
    agent any

    stages {
        stage('---clean---') {
            steps {
                sh "mvn clean"
            }
        }
        stage('--test--') {
            steps {
                sh "mvn test"
            }
        }
        stage('--package--') {
            steps {
                sh "mvn package"
            }
        }
        stage('--deploy--') {
            steps {
                sh "mvn deploy"
            }
        }

        stage('--docker-build--') {
                   steps {
                       sh 'docker build -t jonathangeorgiou/devopsproject .'
                   }
        }


        stage('--docker-publish--') {
            steps {
                withDockerRegistry([ credentialsId: "jonDH", url: "" ]) {
                sh 'docker push jonathangeorgiou/devopsproject:latest'
                }
            }

        }
    }
 }