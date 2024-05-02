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
      def waitForApproval(message) {
        script {
          def userInput = input(
                  id: 'ProceedOrAbort',
                  message: message,
                  parameters: [
                          choice(choices: ['Proceed', 'Abort'], description: 'Select action to take')
                  ]
          )
          if (userInput == 'Abort') {
            error('Pipeline aborted by user')
          }
        }
      }
      echo "two"
    }
  }
  catch (v) {
    stage("post-action") {
      echo 'This will run only if failed'
    }
  }
}