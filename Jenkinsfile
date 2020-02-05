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
        stage('--separate--') {
            steps {

                sh 'mv BookingSystem/src/main/resources/static ~/front-end'
            }
        }
        stage('--docker-build-back-end--') {
                   steps {
                       sh 'docker build -t jonathangeorgiou/back-end .'
                   }
        }
        stage('--docker-build-front-end--') {
                           steps {
                               cd '~/front-end'
                               sh 'docker build -t jonathangeorgiou/front-end .'
                           }
                }
        stage('--docker-publish--') {
            steps {
                withDockerRegistry([ credentialsId: "jonDH", url: "" ]) {
                sh 'docker push jonathangeorgiou/back-end:latest'
                sh 'docker push jonathangeorgiou/front-end:latest'
            }
        }

        }
     }
 }