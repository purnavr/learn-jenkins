node('workstation') {
  env.SAMPLE_URL = "google.com"
  try {
    withCredentials([usernameColonPassword(credentialsId: 'SSH', variable: 'USERPASS')]) {
      stage("one") {
        echo "one"
        sh 'env'
        sh 'env >/tmp/env'
      }
    }
    stage("two") {
      echo "two"
    }
  }
  catch (v) {
    stage("post-action") {
      echo 'This will run only if failed'
    }
  }
}