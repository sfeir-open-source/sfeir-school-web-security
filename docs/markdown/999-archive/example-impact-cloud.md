<!-- .slide: class="transition" -->
# Examples: SaaS / Cloud



##==##

# Gmail

- Identity theft in Gmail - send email as if you were someone else ( [source](https://www.numerama.com/cyberguerre/643343-comment-un-bug-sur-gmail-permettait-dusurper-ladresse-de-nimporte-quel-utilisateur.html) )
- Closed source. Gmail vulnerable since ... ?
- Disclosed to Gogle on 3/4/2020
- Only fixed... 137 days later
<!-- .element: class="list-fragment" -->



##==##

# Amazon / AWS

- 11/2022: Vulnerability allowed unauthorized access to cloud resources ( [source](https://portswigger.net/daily-swig/vulnerability-in-aws-appsync-allowed-unauthorized-access-to-cloud-resources) )
- Discovered by DataDog (Cloud Monitoring as a Service company)
- Impact example: anyone can obtain full control over specific cloud-hosted databases
- See also https://aws.amazon.com/fr/security/security-bulletins/
<!-- .element: class="list-fragment" -->



##==##

# Microsoft / Azure

- 03/2023: Misconfiguration in Azure Active Directory - compromised Bing management portal ( [source](https://www.wiz.io/blog/azure-active-directory-bing-misconfiguration) )
- Discovered by Wiz (Cloud Security company)
- Impact example:
<!-- .element: class="list-fragment" -->
- it was possible to control the Bing.com search results,
- to access Outlook emails and calendars,
- Teams messages,
- SharePoint docs of other users...
<!-- .element: class="list-fragment" -->

Notes:
- bing.com: eg to launch phishing campaigns


##==##

# Google / GCP

- Malicious authorized apps become invisible in Google application management page ( [source](https://www.bleepingcomputer.com/news/security/ghosttoken-gcp-flaw-let-attackers-backdoor-google-accounts/) )
- Discovered by Astrix ( Security software company )
<!-- .element: class="list-fragment" -->

Notes:
- Scenario: the user add an app on his account. Then he notices the app is malicious, he accesses the page to remove linked applications, but the app is not displayed there.
