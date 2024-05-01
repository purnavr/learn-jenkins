node('workstation') {
  try {
    stage("one") {
      echo "one"
      sh 'exit 1'
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