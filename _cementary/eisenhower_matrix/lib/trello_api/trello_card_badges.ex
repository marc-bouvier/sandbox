defmodule TrelloCardBadges do
  @derive [Poison.Encoder]
  defstruct [
    :votes,
    :attachmentsByType,
    :subscribed,
    :comments,
    :due
  ]
end
