node {
    stages {
        stage('E2E Tests - CHROME') {
            mvn "clean install -DskipTests=true"
            mvn "surefire:test"
        }
    }
}
