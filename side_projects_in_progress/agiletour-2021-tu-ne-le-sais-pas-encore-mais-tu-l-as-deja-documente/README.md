# Tu ne le sais pas encore mais tu l'as déjà documenté!

Proposition de talk pour l'Agile tour 2021 à Strasbourg.
Au sujet de la documentation vivante.

## Generation des slides

```
# Convert slide deck into HTML
npx @marp-team/marp-cli@latest slides.md -o index.html

# Convert slide deck into PDF
npx @marp-team/marp-cli@latest slides.md -o dist/index.pdf --pdf

# Convert slide deck into PowerPoint document (PPTX)
npx @marp-team/marp-cli@latest slides.md -o dist/index.pptx --pptx

# Watch mode
npx @marp-team/marp-cli@latest -w slides.md -o index.html

```