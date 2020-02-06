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
        stage('--terraform--'){
            steps{
            dir(/home/ubuntu){
            sh 'sudo rm -rf SeleniumGrid/'
            sh 'git clone https://github.com/jkiesslinger/SeleniumGrid.git'
            }
                dir(/home/ubuntu){
                sh 'sudo terraform init'
                                sh 'sudo terraform apply'
                                timeout(time: 2, unit: "HOURS") {
                                    input message: 'Approve Testing?', ok: 'Yes'
                                }
                                sh 'sudo mvn clean test'
                                sh 'sudo terraform destroy'
                }

                }
                }

        }
    }