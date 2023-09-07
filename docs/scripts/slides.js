import { SfeirThemeInitializer } from '../web_modules/sfeir-school-theme/sfeir-school-theme.mjs';

/**
 * If there is not enough time, slides that can be skipped:
 * - In 102-examples-and-impacts: just talk about libraries examples (skip 102-tools, 102-open-source, 102-data-leaks)
 * - 301-secure-sdlc-methodo (just give methodologies names and then skip)
 *
 * If there is more time:
 * - Show the section 500-bonus.
 * - take more time on the exercises: ask them to find vulnerabilities, exploit them, but also fix them.
 */

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
      '102-risks-and-impacts.md',
    ].map(relativePath => '100-web-sec-overview/102-examples-and-impacts/' + relativePath);
  }
  return [
    ...mainGuidelines(),
    ...examplesAndImpacts(),
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
    // TODO '200-owasp-top-10/230-pause.md', => when ?
    ...owaspCveOverview(),
    ...owaspTop10Overview(),
    ...owaspTop10_cat01(),
    ...owaspTop10_cat02(),
    ...owaspTop10_cat03(),
    '200-owasp-top-10/231-exercise.md',
    '200-owasp-top-10/231-exercise-cat-1-2-3.md', // Search category 1
    ...owaspTop10_cat04(),
    ...owaspTop10_cat05(),
    '200-owasp-top-10/231-exercise.md',
    '200-owasp-top-10/231-exercise-cat-4-5.md', // Search category 5
    ...owaspTop10_cat06(),
    ...owaspTop10_cat07(),
    '200-owasp-top-10/231-exercise.md',
    '200-owasp-top-10/231-exercise-cat-6-7.md', // Search category 6 and 7
    ...owaspTop10_cat08(),
    ...owaspTop10_cat09(),
    ...owaspTop10_cat10(),
    '200-owasp-top-10/231-exercise.md',
    '200-owasp-top-10/231-exercise-cat-8-9-10.md', // Search category 8 and 9 (and 1 - path traversal)
    ...owaspTop10_moreResources(),
  ];
}

function methodologiesSlides() {
  return [
    '300-methodologies/301-secure-sdlc.md',
    '300-methodologies/301-secure-sdlc-methodo.md',
    '300-methodologies/302-tools.md',
  ];
}

function conclusionSlides() {
  return [
    '400-conclusion/401-conclusion.md',
  ];
}

function bonusSlides() {
  return [
    '500-bonus/501-how-to-convince.md'
  ];
}

function training() {
  return [
    ...introductionSlides(),
    ...webSecOverviewSlides(),
    ...owaspTop10Slides(),
    ...methodologiesSlides(),
    ...conclusionSlides(),
    ...bonusSlides(),
  ].map((path) => ({ path }));
}

SfeirThemeInitializer.init(training);
