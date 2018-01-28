node {
    stage('E2E Tests - CHROME') {
    sh "mvn clean install -DskipTests=true"
    sh "mvn surefire:test"
    }
}
