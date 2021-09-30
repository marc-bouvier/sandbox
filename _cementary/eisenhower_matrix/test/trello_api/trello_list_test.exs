defmodule TrelloListTest do
  use ExUnit.Case
  doctest TrelloList

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

  test "parse trello list simple" do
    trello_list = TrelloList.decode_list(~s([
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
      ]))

    assert trello_list === [
             %TrelloList{
               closed: false,
               id: "5b718a037f01b76d5e29d922",
               idBoard: "5b7189ecc17f477c871b9619",
               name: "Necessity - Important & Urgent",
               pos: 65535.5,
               subscribed: false
             },
             %TrelloList{
               closed: false,
               id: "5b718a19d04d415026bb1bb1",
               idBoard: "5b7189ecc17f477c871b9619",
               name: "Quality & personal leadership - Important & Not urgent",
               pos: 131_071,
               subscribed: false
             },
             %TrelloList{
               closed: false,
               id: "5b718a25c17f477c871ba96e",
               idBoard: "5b7189ecc17f477c871b9619",
               name: "Deception - Not important & Urgent",
               pos: 196_607,
               subscribed: false
             },
             %TrelloList{
               closed: false,
               id: "5b718a3df3f1183d4ee067b1",
               idBoard: "5b7189ecc17f477c871b9619",
               name: "Waste - Not Important & Not Urgent",
               pos: 262_143,
               subscribed: false
             }
           ]
  end
end
