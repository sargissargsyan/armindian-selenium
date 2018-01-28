node {
            stage('E2E Tests - CHROME') {
                mvn "clean verify -DskipTests=true"
                mvn "failsafe:integration-test -P selenium-tests"
            }
}

def mvn(String goals) {
    def mvnHome = tool "Maven 3"
    def javaHome = tool "JAVA 8"
    withEnv(["JAVA_HOME=${javaHome}", "PATH+MAVEN=${mvnHome}/bin", "DISPLAY=:1.5"]) {
        sh "mvn ${goals}"
    }
}
