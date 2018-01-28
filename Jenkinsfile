#!groovy
timestamps {
    def buildTag

    node {
        try {

            stage('E2E Tests - CHROME') {
                mvn "clean install -DskipTests=true"
                mvn "surefire:test"
            }


        } catch (err) {
            currentBuild.result = 'UNSTABLE'
        }

    }
}
//Run Maven with predefined environment
def mvn(String goals) {
    def mvnHome = tool "Maven 3"
    def javaHome = tool "JAVA 8"
    withEnv(["JAVA_HOME=${javaHome}", "PATH+MAVEN=${mvnHome}/bin", "DISPLAY=:1.5"]) {
        sh "mvn ${goals}"
    }
}