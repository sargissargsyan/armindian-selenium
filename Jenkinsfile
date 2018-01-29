pipeline {
    agent any
    tools { 
        maven 'maven' 
    }

        stage ('Build') {
            steps {
                sh '''
                    mvn clean install -DskipTests
                    mvn surefire:test
                    '''
            }
        }
 }
