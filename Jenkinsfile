pipeline {

    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Publish Reports') {
            steps {
                junit 'target/surefire-reports/*.xml'
            }
        }
    }

    post {

        always {
            archiveArtifacts artifacts: 'target/surefire-reports/**/*', allowEmptyArchive: true
            archiveArtifacts artifacts: 'screenshot/**/*', allowEmptyArchive: true
        }

        success {
            echo 'Automation tests passed successfully.'
        }

        failure {
            echo 'Automation tests failed. Please check the Jenkins console and test reports.'
        }
    }
}