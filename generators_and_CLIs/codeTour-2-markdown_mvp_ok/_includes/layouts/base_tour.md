---
layout: layouts/tours.njk
repoUrl: CHANGE_ME_WITH_REPO_URL
repoFileBrowseUrl: CHANGE_ME_WITH_REPO_BROWSE_URL
---
# {{title}}

Git repo that reference the code tour : [{{ repoUrl }}]({{ repoUrl }}).
On branch or commit ["{{ref}}"]({{repoFileBrowseUrl}}/{{ref}}).

{% for step in steps %}

{{ step.description }}

Browse code : [{{ step.file }}]({{repoFileBrowseUrl}}/{{ref}}/{{ step.file }})
{% collapsible %}
``` {{step.file | languageFromFilename}}/{{ step.line }}
{{step.contents}}
```
{% endcollapsible %}
{% endfor %}
