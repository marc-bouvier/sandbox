# 1. Container/Component separation

Date: 2018-08-13

## Status

Accepted

## Context

We don't want to have data accessed from everywhere in the application. We want to be able to test responsibilities of the application separately.

## Decision

We will separate vueJs components in 2 categories : Container and Component

### Container

A container will handle retrieval of data from the global state and dispatch it to components via their props. A container is purely data fetching related and does not contain templating other than component wrapping nor style.

It listens to events and dispatch actions.

A container matches a module of the store.

### Component

A component will accept data from a container ot another component as props and be in charge of the layout of that data.

For any changes and actions required, it will emit an event up.


## Consequences

Testing will be made easier. This will allow to have 3 categories of tests:
* Component
* Container
* Store

Ive seen this separation explained here : https://medium.com/@kornatzky/structure-a-vue-js-app-from-containers-and-components-52fe0922620c

