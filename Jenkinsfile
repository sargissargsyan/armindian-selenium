pipeline {
    agent any
    tools { 
        maven 'maven' 
        docker 'docker'
    }
    stages {
        stage ('Build') {
            steps {
                sh '''
                    mvn clean install -DskipTests
                    mvn surefire:test
                    '''
            }
        }
    }
}
