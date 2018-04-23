import jenkins.model.*
import hudson.security.SecurityRealm
import org.jenkinsci.plugins.GithubSecurityRealm
def instance = Jenkins.getInstance()
String githubWebUri = 'https://github.com'
String githubApiUri = 'https://api.github.com'
String clientID = System.getenv('GITHUB_CLIENT_ID')
String clientSecret = System.getenv('GITHUB_SECRET_KEY')
String oauthScopes = 'read:org'
SecurityRealm github_realm = new GithubSecurityRealm(githubWebUri, githubApiUri, clientID, clientSecret, oauthScopes)
//check for equality, no need to modify the runtime if no settings changed
if(!github_realm.equals(instance.getSecurityRealm())) {
    instance.setSecurityRealm(github_realm)
    instance.save()
}
