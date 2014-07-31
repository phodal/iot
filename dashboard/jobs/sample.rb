require "rubygems"
require "json"
require "net/http"
require "uri"

def get_data(num)
  uri = URI.parse("http://b.phodal.com/athome/"+num.to_s)
 
    http = Net::HTTP.new(uri.host, uri.port)
    request = Net::HTTP::Get.new(uri.request_uri)
 
    response = http.request(request)

    result=JSON.parse(response.body)
    result
end

current_valuation = 0
current_karma = 0

SCHEDULER.every '2s' do
  last_valuation = current_valuation
  current_valuation = rand(100)
  current_temperature = get_data(2)[0]["temperature"].to_i
  last_temperature = get_data(1)[0]["temperature"].to_i

  sensors1 = get_data(2)[0]["sensors1"].to_i
  send_event('karma', { current: current_valuation, last: last_valuation })
  send_event('temperature', { current: current_temperature, last: last_temperature })
  send_event('sensors1',   { value: sensors1})
end
