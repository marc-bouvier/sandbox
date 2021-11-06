---
pagination:
  data: marc-bouvier.github-stars
  size: 500
---

<table>
<thead>
<tr>
<th>Repo</th>
<th>Stars</th>
<th>Language</th>
<th>Open Issues</th>
<th>Watchers</th>
<th>Forks</th>
<th>Description</th>
<th>Homepage</th>
</thead>
<tbody>
{% for repo in pagination.items %}
<tr>
<td><a href="{{ repo.html_url }}">{{ repo.full_name }}</a></td>
<td> {{ repo.stargazers_count }} </td>
<td> {{ repo.language }} </td>
<td> {{ repo.open_issues }} </td>
<td> {{ repo.watchers }} </td>
<td> {{ repo.forks }} </td>
<td> {{ repo.description }} </td>
<td> {{ repo.homepage }} </td>
</tr>
{% endfor %}
</tbody>
</table>

<a href="{{pagination.href.first}}">First Page</a> | <a href="{{pagination.href.previous}}">Previous Page</a> | <a href="{{pagination.href.next}}">Next Page</a> | <a href="{{pagination.href.last}}">Last Page</a>