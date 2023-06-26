# Security Logging and Monitoring Failures - Log injection

- Forge log entries
- Example:
<!-- .element: class="list-fragment" -->

```
logger.warn("Bad value received: " + value);
```
<!-- .element: class="fragment" -->

``` text
WARN: Bad value received: some value
```
<!-- .element: class="fragment" -->



##==##

# Security Logging and Monitoring Failures - Log injection

- Forge log entries
- Example:
  - some%20value%0A
    INFO%3A%20User%20badguy%20updated%20his%20pseudo%20to%20someguy%0A
    INFO%3A%20User%20goodguy%20updated%20his%20pseudo%20to%20badguy%0A
<!-- .element: class="list-fragment" -->

```
logger.warn("Bad value received: " + value);
```
<!-- .element: class="fragment" -->

``` text
WARN: Bad value received: some value
INFO: User badguy (id XXX) updated his pseudo to someguy
INFO: User goodguy (id YYY) updated his pseudo to badguy
```
<!-- .element: class="fragment" -->

Notes:
- attacker can inject log entries easily
- note: for audit events, better to use immutable data (eg user ID)



##==##

# Security Logging and Monitoring Failures - Missing logs

- only log failed login attempts after X attempts
- no logging of user rights updates
- no logging of the actions author
- ...
<!-- .element: class="list-fragment" -->
