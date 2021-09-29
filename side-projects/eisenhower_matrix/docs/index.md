# Daily log - Eisenhower matrix in elixir

## Bootstrapping project

Pheonix project without Ecto. I am not sure I need SQL for now.

```
mix phx.new --no-ecto eisenhower_matrix
* creating eisenhower_matrix/config/config.exs
* creating eisenhower_matrix/config/dev.exs
* creating eisenhower_matrix/config/prod.exs
* creating eisenhower_matrix/config/prod.secret.exs
* creating eisenhower_matrix/config/test.exs
* creating eisenhower_matrix/lib/eisenhower_matrix/application.ex
* creating eisenhower_matrix/lib/eisenhower_matrix.ex
* creating eisenhower_matrix/lib/eisenhower_matrix_web/channels/user_socket.ex
* creating eisenhower_matrix/lib/eisenhower_matrix_web/views/error_helpers.ex
* creating eisenhower_matrix/lib/eisenhower_matrix_web/views/error_view.ex
* creating eisenhower_matrix/lib/eisenhower_matrix_web/endpoint.ex
* creating eisenhower_matrix/lib/eisenhower_matrix_web/router.ex
* creating eisenhower_matrix/lib/eisenhower_matrix_web.ex
* creating eisenhower_matrix/mix.exs
* creating eisenhower_matrix/README.md
* creating eisenhower_matrix/test/support/channel_case.ex
* creating eisenhower_matrix/test/support/conn_case.ex
* creating eisenhower_matrix/test/test_helper.exs
* creating eisenhower_matrix/test/eisenhower_matrix_web/views/error_view_test.exs
* creating eisenhower_matrix/lib/eisenhower_matrix_web/gettext.ex
* creating eisenhower_matrix/priv/gettext/en/LC_MESSAGES/errors.po
* creating eisenhower_matrix/priv/gettext/errors.pot
* creating eisenhower_matrix/lib/eisenhower_matrix_web/controllers/page_controller.ex
* creating eisenhower_matrix/lib/eisenhower_matrix_web/templates/layout/app.html.eex
* creating eisenhower_matrix/lib/eisenhower_matrix_web/templates/page/index.html.eex
* creating eisenhower_matrix/lib/eisenhower_matrix_web/views/layout_view.ex
* creating eisenhower_matrix/lib/eisenhower_matrix_web/views/page_view.ex
* creating eisenhower_matrix/test/eisenhower_matrix_web/controllers/page_controller_test.exs
* creating eisenhower_matrix/test/eisenhower_matrix_web/views/layout_view_test.exs
* creating eisenhower_matrix/test/eisenhower_matrix_web/views/page_view_test.exs
* creating eisenhower_matrix/.gitignore
* creating eisenhower_matrix/assets/brunch-config.js
* creating eisenhower_matrix/assets/css/app.css
* creating eisenhower_matrix/assets/css/phoenix.css
* creating eisenhower_matrix/assets/js/app.js
* creating eisenhower_matrix/assets/js/socket.js
* creating eisenhower_matrix/assets/package.json
* creating eisenhower_matrix/assets/static/robots.txt
* creating eisenhower_matrix/assets/static/images/phoenix.png
* creating eisenhower_matrix/assets/static/favicon.ico

Fetch and install dependencies? [Yn] y
* running mix deps.get
* running mix deps.compile
* running cd assets && npm install && node node_modules/brunch/bin/brunch build

We are all set! Go into your application by running:

    $ cd eisenhower_matrix

Start your Phoenix app with:

    $ mix phx.server

You can also run your app inside IEx (Interactive Elixir) as:

    $ iex -S mix phx.server
```

### Update brunch

With my bootstrap, Github has detected a potential vulnerability from `node-growl` dependency.
The vulnerability comes from `loggy` pulled from `brunch.io`.
I had to upgrade `brunch`.

```
cd assets
```
Installed ncu
```
~/s/e/assets ❯❯❯ npm i -g npm-check-updates                                                              ✘ 127 master ◼
/home/marco/.npm-global/bin/npm-check-updates -> /home/marco/.npm-global/lib/node_modules/npm-check-updates/bin/npm-check-updates
/home/marco/.npm-global/bin/ncu -> /home/marco/.npm-global/lib/node_modules/npm-check-updates/bin/ncu
+ npm-check-updates@2.14.2
added 383 packages in 15.239s
```
Performed npm dependencies upgrades with ncu.
```
~/s/e/assets ❯❯❯ ncu -u
Using /home/marco/sources/eisenhower_matrix/assets/package.json
[..................] \ :
 babel-brunch   6.1.1  →    7.0.0 
 brunch        2.10.9  →  2.10.17 
Upgraded /home/marco/sources/eisenhower_matrix/assets/package.json
```
Installed npm dependencies.
```
~/s/e/assets ❯❯❯ npm install                                                                                 master ✱ ◼
npm WARN assets No description
npm WARN optional SKIPPING OPTIONAL DEPENDENCY: fsevents@1.2.4 (node_modules/fsevents):
npm WARN notsup SKIPPING OPTIONAL DEPENDENCY: Unsupported platform for fsevents@1.2.4: wanted {"os":"darwin","arch":"any"} (current: {"os":"linux","arch":"x64"})

added 125 packages, removed 106 packages, updated 30 packages and moved 10 packages in 17.284s

```

This fixed the issue mentionned in [this forum question](https://elixirforum.com/t/github-found-a-potential-security-vulnerability-from-node-growl/15213).

### Run phoenix app for the first time


```
~/s/eisenhower_matrix ❯❯❯ mix phx.server                                                                                                       master ✱ ◼
Compiling 12 files (.ex)
Generated eisenhower_matrix app
[info] Running EisenhowerMatrixWeb.Endpoint with Cowboy using http://0.0.0.0:4000
19:54:32 - info: compiled 6 files into 2 files, copied 3 in 1.3 sec
```

I was able to run the app in my browser : [http://localhost:4000](http://localhost:4000)

## ADR : Architecture decisions records

[Install `adr-tools`](https://github.com/npryce/adr-tools/blob/master/INSTALL.md).

Linux : Downloaded from git repo () and added src to PATH.

```
cd
cd bin 
git clone https://github.com/npryce/adr-tools.git 
```

Then added `export PATH=$PATH:~/bin/adr-tools/src` to `.bashrc` or `.zshrc`.

I got back to the project directory and typed the following:
```
adr init docs/architecture/decisions
```

This created the initial pre-filled  ADR `docs/architecture/decisions/0001-record-architecture-decisions.md `.

```
# 1. Record architecture decisions

Date: 2018-09-17

## Status

Accepted

## Context

We need to record the architectural decisions made on this project.

## Decision

We will use Architecture Decision Records, as [described by Michael Nygard](http://thinkrelevance.com/blog/2011/11/15/documenting-architecture-decisions).

## Consequences

See Michael Nygard's article, linked above. For a lightweight ADR toolset, see Nat Pryce's [adr-tools](https://github.com/npryce/adr-tools).
```

Then I added a new adr : 
```
$> adr new Use Elixir as backend technology
docs/architecture/decisions/0002-use-elixir-as-backend-technology.md 
```
My default text editor opened the generated file and I was able to edit it.
	
Then I added a new adr :
```
$> adr new Use Elixir as backend technology
docs/architecture/decisions/0002-use-elixir-as-backend-technology.md
```
My default text editor opened the generated file and I was able to edit it. 

## Add secret configuration for trello api key

Once logged in trello you can [get your APi key here](https://trello.com/app-key).

`config/dev.secret.exs`
```elixir
use Mix.Config
config :eisenhower_matrix, EisenhowerMatrixWeb.Endpoint,
  trello_public_api_key: "your_trello_api_key",
  trello_secret_authentication_token: "your_secret_authentication_token"
```

Then make sure it is ignored in `.gitignore`

## Get trello samples

Before authenticate to trello we will first build functions to transform trello payloads to our domain model.

Go to trello developper Api sandbox `https://developers.trello.com/page/sandbox/?key=your_trello_api_key

Then connect.

Then authenticate.

Allow the client to connect.

Load your boards, get the id of one board. Then load lists for this board.

You should get something like this :

```json
[
  {
    "id": "5b718a037f01b76d5e29d922",
    "name": "Necessity - Important & Urgent",
    "closed": false,
    "idBoard": "5b7189ecc17f477c871b9619",
    "pos": 65535.5,
    "subscribed": false
  },
  {
    "id": "5b718a19d04d415026bb1bb1",
    "name": "Quality & personal leadership - Important & Not urgent",
    "closed": false,
    "idBoard": "5b7189ecc17f477c871b9619",
    "pos": 131071,
    "subscribed": false
  },
  {
    "id": "5b718a25c17f477c871ba96e",
    "name": "Deception - Not important & Urgent",
    "closed": false,
    "idBoard": "5b7189ecc17f477c871b9619",
    "pos": 196607,
    "subscribed": false
  },
  {
    "id": "5b718a3df3f1183d4ee067b1",
    "name": "Waste - Not Important & Not Urgent",
    "closed": false,
    "idBoard": "5b7189ecc17f477c871b9619",
    "pos": 262143,
    "subscribed": false
  }
]
```

Then load sample data from a list

```
Trello.get('/lists/5b718a037f01b76d5e29d922/cards', success, error);
```

You should get cards data

```json
[
  {
    "id": "5b718bd8687a5070e26197d0",
    "checkItemStates": null,
    "closed": false,
    "dateLastActivity": "2018-10-03T18:25:12.590Z",
    "desc": "",
    "descData": null,
    "idBoard": "5b7189ecc17f477c871b9619",
    "idList": "5b718a037f01b76d5e29d922",
    "idMembersVoted": [],
    "idShort": 1,
    "idAttachmentCover": "5bb509822d017081ae755c39",
    "idLabels": [
      "5b7189ec9c16fb124a38c027",
      "5b7189ec9c16fb124a38c029",
      "5b7189ec9c16fb124a38c02b"
    ],
    "manualCoverAttachment": false,
    "name": "To do right now!",
    "pos": 65535,
    "shortLink": "bf7qemsF",
    "badges": {
      "votes": 0,
      "attachmentsByType": {
        "trello": {
          "board": 0,
          "card": 0
        }
      },
      "viewingMemberVoted": false,
      "subscribed": true,
      "fogbugz": "",
      "checkItems": 2,
      "checkItemsChecked": 0,
      "comments": 1,
      "attachments": 1,
      "description": false,
      "due": "2018-10-06T10:00:00.000Z",
      "dueComplete": false
    },
    "dueComplete": false,
    "due": "2018-10-06T10:00:00.000Z",
    "idChecklists": [
      "5bb509681a21bd0dc3122fdf"
    ],
    "idMembers": [
      "563cc9d167fd2b93d93201a6"
    ],
    "labels": [
      {
        "id": "5b7189ec9c16fb124a38c027",
        "idBoard": "5b7189ecc17f477c871b9619",
        "name": "",
        "color": "green"
      },
      {
        "id": "5b7189ec9c16fb124a38c029",
        "idBoard": "5b7189ecc17f477c871b9619",
        "name": "",
        "color": "yellow"
      },
      {
        "id": "5b7189ec9c16fb124a38c02b",
        "idBoard": "5b7189ecc17f477c871b9619",
        "name": "test",
        "color": "pink"
      }
    ],
    "shortUrl": "https://trello.com/c/bf7qemsF",
    "subscribed": true,
    "url": "https://trello.com/c/bf7qemsF/1-to-do-right-now"
  },
  {
    "id": "5b86b10d966d0a4989526da0",
    "checkItemStates": null,
    "closed": false,
    "dateLastActivity": "2018-08-29T15:14:41.359Z",
    "desc": "- [The beauty of data visualization - David McCandless](https://www.youtube.com/watch?v=5Zg-C8AAIGg)\n- [The Future of Data Visualization on the Web - Alan Mendelevich](https://www.youtube.com/watch?v=nH8YZvfLa4M)\n- [SVG can do that?! (Sarah Drasner)](https://www.youtube.com/watch?v=ADXX4fmWHbo)\n- [Svg can do that!? slides](http://slides.com/sdrasner/svg-can-do-that)\n- [d3.js gallery](https://d3js.org)\n\nSee what is used in technology radar\n",
    "descData": {
      "emoji": {}
    },
    "idBoard": "5b7189ecc17f477c871b9619",
    "idList": "5b718a037f01b76d5e29d922",
    "idMembersVoted": [],
    "idShort": 5,
    "idAttachmentCover": null,
    "idLabels": [],
    "manualCoverAttachment": false,
    "name": "Data visualisation for client charts",
    "pos": 131071,
    "shortLink": "mM8k2Qwu",
    "badges": {
      "votes": 0,
      "attachmentsByType": {
        "trello": {
          "board": 0,
          "card": 0
        }
      },
      "viewingMemberVoted": false,
      "subscribed": false,
      "fogbugz": "",
      "checkItems": 0,
      "checkItemsChecked": 0,
      "comments": 0,
      "attachments": 0,
      "description": true,
      "due": null,
      "dueComplete": false
    },
    "dueComplete": false,
    "due": null,
    "idChecklists": [],
    "idMembers": [],
    "labels": [],
    "shortUrl": "https://trello.com/c/mM8k2Qwu",
    "subscribed": false,
    "url": "https://trello.com/c/mM8k2Qwu/5-data-visualisation-for-client-charts"
  },
  {
    "id": "5b7188a546729d334fdcf52f",
    "checkItemStates": null,
    "closed": false,
    "dateLastActivity": "2018-09-15T10:20:44.004Z",
    "desc": "https://marc-bouvier.github.io/2018/08/13/hacking-your-work-life-balance-Jennifer-Wadella/",
    "descData": {
      "emoji": {}
    },
    "idBoard": "5b7189ecc17f477c871b9619",
    "idList": "5b718a037f01b76d5e29d922",
    "idMembersVoted": [],
    "idShort": 6,
    "idAttachmentCover": null,
    "idLabels": [],
    "manualCoverAttachment": false,
    "name": "Graphe de eisenhower depuis Trello",
    "pos": 147455,
    "shortLink": "5py0tGre",
    "badges": {
      "votes": 0,
      "attachmentsByType": {
        "trello": {
          "board": 0,
          "card": 0
        }
      },
      "viewingMemberVoted": false,
      "subscribed": false,
      "fogbugz": "",
      "checkItems": 0,
      "checkItemsChecked": 0,
      "comments": 0,
      "attachments": 0,
      "description": true,
      "due": null,
      "dueComplete": false
    },
    "dueComplete": false,
    "due": null,
    "idChecklists": [],
    "idMembers": [],
    "labels": [],
    "shortUrl": "https://trello.com/c/5py0tGre",
    "subscribed": false,
    "url": "https://trello.com/c/5py0tGre/6-graphe-de-eisenhower-depuis-trello"
  },
  {
    "id": "5b9fdff7618d422dbb895ef2",
    "checkItemStates": null,
    "closed": false,
    "dateLastActivity": "2018-09-17T17:10:15.104Z",
    "desc": "",
    "descData": null,
    "idBoard": "5b7189ecc17f477c871b9619",
    "idList": "5b718a037f01b76d5e29d922",
    "idMembersVoted": [],
    "idShort": 7,
    "idAttachmentCover": null,
    "idLabels": [],
    "manualCoverAttachment": false,
    "name": "Log",
    "pos": 212991,
    "shortLink": "9RtSFdwf",
    "badges": {
      "votes": 0,
      "attachmentsByType": {
        "trello": {
          "board": 0,
          "card": 0
        }
      },
      "viewingMemberVoted": false,
      "subscribed": false,
      "fogbugz": "",
      "checkItems": 0,
      "checkItemsChecked": 0,
      "comments": 0,
      "attachments": 0,
      "description": false,
      "due": null,
      "dueComplete": false
    },
    "dueComplete": false,
    "due": null,
    "idChecklists": [],
    "idMembers": [],
    "labels": [],
    "shortUrl": "https://trello.com/c/9RtSFdwf",
    "subscribed": false,
    "url": "https://trello.com/c/9RtSFdwf/7-log"
  }
]
```

Let's parse it with poison. Poison is already present as a dependency from Phoenix. We can use it directly.

`eisenhower_matrix/lib/trello_api/trello_list.ex`
```elixir
defmodule TrelloList do
  @derive [Poison.Encoder]
  defstruct [:id, :name, :closed, :idBoard, :pos, :subscribed]

  def decode(json) do
    Poison.decode!(json, as: %TrelloList{})
  end
end
```


Test the parser
`eisenhower_matrix/test/trello_api/trello_list_test.exs`
```elixir
  test "parse trello list" do
    trello_list = TrelloList.decode(~s({
      "id": "5b718a037f01b76d5e29d922",
      "name": "Necessity - Important & Urgent",
      "closed": false,
      "idBoard": "5b7189ecc17f477c871b9619",
      "pos": 65535.5,
      "subscribed": false
    }))

    assert trello_list === %TrelloList{
             id: "5b718a037f01b76d5e29d922",
             name: "Necessity - Important & Urgent",
             closed: false,
             idBoard: "5b7189ecc17f477c871b9619",
             pos: 65535.5,
             subscribed: false
           }
  end
```
## Design our domain model

We know we want to get some of the data form boards and cards and transform them to be 
able to show them differently. We need a convenient common format that we can transform
later if needed.

From trello api modules structures we will be able to map to other structures more convenient for domain manipulation.

* Trello board list will represent a quadrant for the eisenhower chart. It will map to urgency and importance dimensions.
* Position of cards in a list will represent priority dimension.
* We may want to represent some extra behaviour with labels (such as extra priority for "disaster" red label.
* A card will represent a task.
