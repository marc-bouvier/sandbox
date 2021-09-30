# 1. VueJs

Date: 2018-08-13

## Status

Accepted

## Context

We need to have lightweight and dynamic application that can run against remote APIs.
The framework is already known by me. I (marc-bouvier) also want to apply some best practices (tests...) I wasn't able to enforce in previous similar projects.

VueJs 2.0 is mature and there is a great community that supports it.

## Decision

We will use vueJs javascript framework https://vuejs.org

## Consequences

It will be harder to switch to another template engine later if required. 

VueJs Friendliness with javascript ecosystem will facilitate integration with other javascript libraries.

Bootstrapping the application will be faster.

Hopefully we will be able to externalize the application as an independant module to ibject in simple html page.