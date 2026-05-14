pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                echo 'Checkout source code'
            }
        }

        stage('Build and Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        success {
            echo 'CI completed successfully'
        }

        failure {
            echo 'CI failed'
        }
    }
}