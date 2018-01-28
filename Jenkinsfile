pipeline {
    agent any
    tools { 
        maven 'maven' 
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                 docker run -d --name=grid -p 4444:24444 -p 5900:25900 -v /dev/shm:/dev/shm --privileged -e MAX_INSTANCES=20 -e MAX_SESSIONS=20 elgalu/selenium
                 ''' 
            }
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
}
