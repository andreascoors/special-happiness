# Projekt Fallstudie (ENTWURF)

## Ziel

Es ist eine Software zu entwickeln, die die Verwaltung von Projekten ermöglicht.

### Anforderungen an die Datenbank

* Zeitraum des Projekts
* Name des Projekts
* Projektbeschreibung
* Mitarbeiter*innen
   * Name
   * Vorname
   * Geburtsdatum
   * Mitarbeiterid
   * *... weitere*
* Arbeitspakete
   * Name
   * Beschreibung
   * Start- und Enddatum
   * Aufwand (?)
   * verantwortliche Mitarbeiter*innen (OneToMany)
   * *weitere?*

### Sicherheitsanforderungen

Nur zugehörige Mitarbeiter*innen können die Projektdaten sehen, wenn sie sich anmelden.

### funktionale Anforderungen

* eine Liste der Projekte inkl. der Summe des Aufwand aller zugehörigen AP
* CRUD-Operationen auf alle Entitäten die für Anwender erreichbar sind
* Pflege von Basislisten

# Anforderung (Originaltext)

*Rahmenthema „Planen und realisieren Sie eine Web-Anwendung … “*

> Es ist eine Software zu entwickeln, die die Verwaltung von Projekten ermöglicht. Je Projekt werden Angaben zum Zeitraum (Start- und Enddatum), eine Beschreibung und eine Liste zugehöriger Mitarbeiter*innen gespeichert. Nur zugehörige Mitarbeiter*innen können die Projektdaten sehen, wenn sie sich anmelden. Herzstück der Projektdaten stellt die Liste der Arbeitspakete (AP) dar. Je AP werden die Eigenschaften Name, Beschreibung, Start- und Enddatum, Aufwand und verantwortliche Mitarbeiter*innen (1:N) gespeichert. Die Anwendung zeigt angemeldeten Anwender*innen in der Liste der Projekte die Summe des Aufwand aller zugehörigen Arbeitspakete. Es sind CRUD-Operationen auf alle Entitäten zu realisieren, die für Anwender*innen über die Web-Anwendung erreichbar sind. Dies schließt auch die Pflege von Basislisten ein.
