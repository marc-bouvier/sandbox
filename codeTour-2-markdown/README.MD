## Core concept

Convert [`.tour`][codetour-schema] json description file to an html file that can be published as a blog post.

This way, I can at the same time document some codebase for onboarding and also publish it as a blog post.

## Generate site

Only once

```
npm install @11ty/eleventy-plugin-syntaxhighlight --save-dev
```

Then when you want to generate

```
npx @11ty/eleventy
```


## How to add a code tour

- In `posts/tours`, add an exported code tour file. Renamed the following way.
    - `my-tour-name.tour` becomes `my-tour-name.tour.22tydata.json`
- create a markdown file following the convention : `my-tour-name.tour.md`

Ex.

```
posts/tours
   mobilizon-frontend.tour.11tydata.json
   mobilizon-frontend.tour.md
```

You don't need to change the content of the code tour file except for its name

In the markdown file, you must set variables for the repository url and for the file browsing URL of the repo.

in `mobilizon-frontend.tour.md` it is done the following way :

```md
---
repoUrl: https://framagit.org/framasoft/mobilizon
repoFileBrowseUrl: https://framagit.org/framasoft/mobilizon/-/blob
---
```

When generated, you can see the html here : `http://localhost:8080/posts/tours/mobilizon-frontend.tour/` 

## Considered technologies

- [11ty][11ty] for fast and easy file generation

[codetour-schema]:https://aka.ms/codetour-schema
[11ty]:https://www.11ty.dev/

## Ideas & notes

- Url of the git repo is not present in the tour file. This information should be added independently.

```bash
npx @11ty/eleventy
```

- TODO : make it a github action or gitlab equivalent