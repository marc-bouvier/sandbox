defmodule EisenhowerMatrixWeb.PageController do
  use EisenhowerMatrixWeb, :controller

  def index(conn, _params) do
    render conn, "index.html"
  end
end
