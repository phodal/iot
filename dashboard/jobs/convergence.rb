# Populate the graph with some random points

require "rubygems"
require "json"
require "net/http"
require "uri"

def get_data
  uri = URI.parse("http://b.phodal.com/athome")

  http = Net::HTTP.new(uri.host,uri.port)
  request = Net::HTTP::Get.new(uri.request_uri)

  response=http.request(request)
  result=JSON.parse(response.body)

  result.map do |data|
    {x: data["id"].to_i, y: data["temperature"].to_i}
  end
end

points=get_data

SCHEDULER.every '2s' do
  send_event('tempdata', points: points)
end
