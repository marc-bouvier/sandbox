# Tu ne le sais pas encore mais tu l'as déjà documenté!

Proposition de talk pour l'Agile tour 2021 à Strasbourg.
Au sujet de la documentation vivante.

## Generation des slides

### Asciidoctor-revealjs

Install : https://docs.asciidoctor.org/reveal.js-converter/latest/setup/node-js-setup/

```bash
npm install
# Test Cli is available
npx asciidoctor-revealjs --version
```

Génération

```bash
npx asciidoctor-revealjs slides.adoc -o index.html
```