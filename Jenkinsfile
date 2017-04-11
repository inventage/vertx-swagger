pipeline {
    agent any

    stages {
        stage ('Build') {
            steps {
                echo 'Building..'
                sh 'mvn -B clean'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh 'mvn -B test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying'
                sh 'mvn -B clean deploy'
            }
        }
    }
}
