# Simplified style guide from official vuejs.org

## Essential

- multi-word component names (prevents conflicts with html names)
- component data must be a function (that returns an object)
- prop definitions should be as detailed as possible
- always use `key` with `v-for`
- scope component style (`scoped` attribute, css module, BEM convention, using unique css class name...)
- use `$_` to prefix private property names (e.g. `$_yourPluginName_`) to ovoid conflicts withg Vue properties

## Strongly recommended

- each component should be in its own file (CI will concatenate them)
- single file component should either be PascalCase of kebab-case (PascalCase better for completion in IDE, mixed case works better in case insensitive filesystems)
- base component (a.k.a presentational, dumb, or pure components) that apply app-specific styling should all begin with a specific prefix, such as `Base`, `App`, or `V` (they will be listed together, allows to import them globally with webpack)
- single instance component should begin with `The` to denote that there can be only one
- child components that are tightly coupled with their parent should include the parent component name as a prefix (avoid using folder arborescence)
- component names shoudl start with the highest level (often more general) words and end with descriptive modifying words
- components with no content should be self-closing in single-file components, string templates, and JSX - but never in DOM templates
- in most project, component names should always be in PascalCase in single-file components and string templates - but kebab-case in DOM templates
- component names in JS/JSX should always be PascalCase
- component names should prefer full words over abbreviations (anyway, autocompletion makes it fast to write)
- 

## See also
- [VueJs official style guide](https://vuejs.org/v2/style-guide/)
