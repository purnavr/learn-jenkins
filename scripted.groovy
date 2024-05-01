node('workstation') {
  try {
    stage("one") {
      echo "one"
    }

    stage("two") {
      echo "two"
    }
  } catch (e) {
    stage("two") {
      echo 'This will run only if failed'
    }
  }
}
