# This file is responsible for configuring your application
# and its dependencies with the aid of the Mix.Config module.
#
# This configuration file is loaded before any dependency and
# is restricted to this project.
use Mix.Config

# Configures the endpoint
config :eisenhower_matrix, EisenhowerMatrixWeb.Endpoint,
  url: [host: "localhost"],
  secret_key_base: "Zf8uPnoJyH6P83pGtd8Pa/+NHqjvwnC0zd0hX1m3s/9CR+DqO8ltXyE850A49Mcq",
  render_errors: [view: EisenhowerMatrixWeb.ErrorView, accepts: ~w(html json)],
  pubsub: [name: EisenhowerMatrix.PubSub,
           adapter: Phoenix.PubSub.PG2]

# Configures Elixir's Logger
config :logger, :console,
  format: "$time $metadata[$level] $message\n",
  metadata: [:user_id]

# Import environment specific config. This must remain at the bottom
# of this file so it overrides the configuration defined above.
import_config "#{Mix.env}.exs"
