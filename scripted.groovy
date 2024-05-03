node('workstation') {

  properties([
          parameters([
                  string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Environment')
          ])
  ])

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
      input(id: 'deploy_approval', message: 'Yes or No', ok: 'Continue', reject: 'Cancel')
      echo "two"
    }
  }
  catch (v) {
    stage("post-action") {
      echo 'This will run only if failed'
    }
  }
}


