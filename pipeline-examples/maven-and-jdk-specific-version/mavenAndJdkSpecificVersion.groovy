
env.JAVA_HOME = tool 'jdk-1.8.0'
// Advice: don't define M2_HOME in general. Maven will autodetect its root fine.
def mvnHome   = tool 'maven-3.2.1'
env.PATH="${env.JAVA_HOME}/bin:${mvnHome}/bin:${env.PATH}"

// Side Maven notes:
// --batch-mode : recommended in CI to inform maven to not run in interactive mode (less logs)
// -V : strongly recommended in CI, will display the JDK and Maven versions in use.
//      Very useful to be quickly sure the selected versions was the ones you think.
// -U : force maven to update snapshots each time (default : once an hours, makes no sense in CI).
sh "mvn --batch-mode -V -U -e clean deploy -Dsurefire.useFile=false"
