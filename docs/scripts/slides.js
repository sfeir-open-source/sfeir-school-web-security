import { SfeirThemeInitializer } from '../web_modules/sfeir-school-theme/sfeir-school-theme.mjs';

function introductionSlides() {
  return [
    '00-Intro.md',
    '01-Wifi.md',
    '02-Speaker-Mathieu-Vandenneucker.md',
    '03-SFEIR-prez.md',
    '04-Intro-continued.md',
  ].map(relativePath => '000-introduction/' + relativePath);
}

function webSecOverviewSlides() {
  function mainGuidelines() {
    return [
      '100-web-sec-overview/101-main-guidelines/101-main-guidelines.md',
    ];
  }
  function examplesAndImpacts() {
    return [
      '102-examples-and-impacts.md',
      '102-libraries.md',
      '102-tools.md',
      '102-data-leaks.md',
      '102-open-source.md',
      //'102-cloud.md', // skip for timing reasons
      '102-risks-and-impacts.md',
    ].map(relativePath => '100-web-sec-overview/102-examples-and-impacts/' + relativePath);
  }
  function howToConvince() {
    return [
      '100-web-sec-overview/103-how-to-convince/103-how-to-convince.md'
    ];
  }
  return [
    ...mainGuidelines(),
    ...examplesAndImpacts(),
    ...howToConvince(),
  ];
}

function owaspTop10Slides() {
  function owaspCveOverview() {
    return [
      '200-owasp-top-10/201-owasp-cve-overview/cve.md',
      '200-owasp-top-10/201-owasp-cve-overview/cvss.md',
      '200-owasp-top-10/201-owasp-cve-overview/owasp-overview.md',
    ];
  }
  function owaspTop10Overview() {
    return [
      '200-owasp-top-10/202-owasp-top-10-overview/owasp-top-10.md',
      '200-owasp-top-10/202-owasp-top-10-overview/owasp-top-10-categories.md',
    ];
  }
  function owaspTop10_cat01() {
    return [
      '200-owasp-top-10/211-top10-01-broken-access-control/211-presentation.md',
      '200-owasp-top-10/211-top10-01-broken-access-control/211-cwes.md',
    ];
  }
  function owaspTop10_cat02() {
    return [
      '200-owasp-top-10/212-top10-02-cryptographic-failures/212-presentation.md',
      '200-owasp-top-10/212-top10-02-cryptographic-failures/212-cwes.md',
    ];
  }
  function owaspTop10_cat03() {
    return [
      '200-owasp-top-10/213-top10-03-injection/213-presentation.md',
      '200-owasp-top-10/213-top10-03-injection/213-cwes.md',
    ];
  }
  function owaspTop10_cat04() {
    return [
      '200-owasp-top-10/214-top10-04-insecure-design/214-presentation.md',
      '200-owasp-top-10/214-top10-04-insecure-design/214-cwes.md',
    ];
  }
  function owaspTop10_cat05() {
    return [
      '200-owasp-top-10/215-top10-05-security-misconfiguration/215-presentation.md',
      '200-owasp-top-10/215-top10-05-security-misconfiguration/215-cwes.md',
    ];
  }
  function owaspTop10_cat06() {
    return [
      '200-owasp-top-10/216-top10-06-vulnerable-outdated-component/216-presentation.md',
      '200-owasp-top-10/216-top10-06-vulnerable-outdated-component/216-cwes.md',
    ];
  }
  function owaspTop10_cat07() {
    return [
      '200-owasp-top-10/217-top10-07-identification-authentication-failures/217-presentation.md',
      '200-owasp-top-10/217-top10-07-identification-authentication-failures/217-cwes.md',
    ];
  }
  function owaspTop10_cat08() {
    return [
      '200-owasp-top-10/218-top10-08-software-data-integrity-failures/218-presentation.md',
      '200-owasp-top-10/218-top10-08-software-data-integrity-failures/218-cwes.md',
    ];
  }
  function owaspTop10_cat09() {
    return [
      '200-owasp-top-10/219-top10-09-security-logging-monitoring-failures/219-presentation.md',
      '200-owasp-top-10/219-top10-09-security-logging-monitoring-failures/219-cwes.md',
    ];
  }
  function owaspTop10_cat10() {
    return [
      '200-owasp-top-10/220-top10-10-server-side-request-forgery/220-presentation.md',
    ];
  }
  function owaspTop10_moreResources() {
    return [
      '200-owasp-top-10/221-more-resources/other-flaws-and-resources.md',
    ];
  }

  return [
    ...owaspCveOverview(),
    ...owaspTop10Overview(),
    ...owaspTop10_cat01(),
    ...owaspTop10_cat02(),
    ...owaspTop10_cat03(),
    ...owaspTop10_cat04(),
    '200-owasp-top-10/230-pause.md',
    '200-owasp-top-10/231-exercise.md',
    ...owaspTop10_cat05(),
    ...owaspTop10_cat06(),
    ...owaspTop10_cat07(),
    ...owaspTop10_cat08(),
    ...owaspTop10_cat09(),
    ...owaspTop10_cat10(),
    ...owaspTop10_moreResources(),
    '200-owasp-top-10/231-exercise.md', // continue the previous exercise
  ];
}

function methodologiesSlides() {
  return [
    '300-methodologies/301-secure-sdlc.md',
    '300-methodologies/302-tools.md',
  ];
}

function conclusionSlides() {
  return [
    '400-conclusion/401-conclusion.md',
  ];
}

function training() {
  return [
    ...introductionSlides(),
    ...webSecOverviewSlides(),
    ...owaspTop10Slides(),
    ...methodologiesSlides(),
    ...conclusionSlides(),
  ].map((path) => ({ path }));
}

SfeirThemeInitializer.init(training);
