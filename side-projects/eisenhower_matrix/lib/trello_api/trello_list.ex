defmodule TrelloList do
  @derive [Poison.Encoder]
  defstruct [:id, :name, :closed, :idBoard, :pos, :subscribed]

  def decode(json) do
    Poison.decode!(json, as: %TrelloList{})
  end

  def decode_list(json) do
    Poison.decode!(json, as: [%TrelloList{}])
  end
end
