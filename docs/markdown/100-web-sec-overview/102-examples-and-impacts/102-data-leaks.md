<!-- .slide: class="transition" -->
# Examples: data leaks



##==##

# Accenture - data leak in 2017

- Accenture - a consulting and management company
- Cloud storage buckets publicly accessible
- Content:
  - secret API data
  - auth credentials (including plaintext passwords)
  - certificates
  - customer information...
- See https://www.upguard.com/breaches/cloud-leak-accenture
<!-- .element: class="list-fragment" -->

Notes:
- clients: most of the fortune 100 companies



##==##

# Attunity (Qlik)

- Attunity - data management company
- Cloud storage buckets publicly accessible
- Content (more than one terabyte):
  - clients list
  - internal business documents
  - email backups (including mails containing passwords)
  - employees' OneDrive accounts
  - system credentials
- See https://www.upguard.com/breaches/attunity-data-leak
<!-- .element: class="list-fragment" -->

Notes:
- clients: half of the fortune 100 companies



##==##

# Others

- Utah (USA) COVID-19 testing service - personal data of 50.000 patients exposed publicly ( [source](https://www.comparitech.com/blog/information-security/utah-covid-test-center-leak/) )
- Other examples (AWS bucket leaks): https://github.com/nagwww/s3-leaks
- CNIL (Commission Nationale de l'Informatique et des Libertés - France):
<!-- .element: class="list-fragment" -->
  - 4088 data leaks disclosed to the CNIL in 2022
  - 62,8% due to external attacks
  - Also small companies
<!-- .element: class="list-fragment" -->

Notes:
- Source: CNIL - 2022 annual report (FR)
- Including small cases => "a doctor fined €2500 for publicly accessible medical images (MRI / IRM)"
- CNIL in belgium: APD (Autorité de Protection des Données)
