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
            stage('Set Terraform path') {
             steps {
             script {
             def tfHome = tool name: 'Terraform'
             env.PATH = "${tfHome}:${env.PATH}"
             }
             sh 'terraform — version'
             }
             }
             stage('Provision infrastructure') {
             steps {
             dir('dev')
             {
             sh 'terraform init'
             sh 'terraform plan -out=plan'
             // sh 'terraform destroy -auto-approve'
             sh 'terraform apply plan'
             }
             }
             }
        stage('--terraform--'){
            steps{











                dir("./SeleniumGrid/"){
                sh 'terraform init'
                sh 'terraform apply'
                timeout(time: 2, unit: "HOURS") {
                    input message: 'Approve Testing?', ok: 'Yes'
                }
                sh 'mvn clean test'
                sh 'terraform destroy'
                }

                }
                }

        }
    }