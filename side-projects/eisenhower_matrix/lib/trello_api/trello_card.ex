defmodule TrelloCard do
  @derive [Poison.Encoder]
  defstruct [
    :id,
    :closed,
    :idBoard,
    :idList,
    :idLabels,
    :name,
    :pos,
    :badges,
    :due,
    :idCheckLists,
    :idMembers,
    :labels,
    :shortUrl,
    :subscribed,
    :url
  ]
end
