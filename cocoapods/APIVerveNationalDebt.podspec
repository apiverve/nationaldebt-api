Pod::Spec.new do |s|
  s.name             = 'APIVerveNationalDebt'
  s.version          = '1.2.3'
  s.summary          = 'National Debt provides real-time access to the US national debt (Debt to the Penny).'
  s.description      = <<-'DESC'
National Debt provides real-time access to the US national debt (Debt to the Penny). It returns the total public debt, debt held by the public, intragovernmental holdings, and per-capita debt calculations.

This iOS/macOS SDK provides a convenient way to access the National Debt from APIVerve.
Supports both callback-based and async/await patterns.
                       DESC

  s.homepage         = 'https://apiverve.com/marketplace/nationaldebt?utm_source=cocoapods&utm_medium=referral&utm_content=homepage'
  s.license          = { :type => 'MIT', :file => 'LICENSE' }
  s.author           = { 'APIVerve' => 'hello@apiverve.com' }
  # The SDK repo holds every language; the pod lives under cocoapods/ with its own tag.
  s.source           = { :git => 'https://github.com/apiverve/nationaldebt-api.git', :tag => "cocoapods/v#{s.version}" }

  s.ios.deployment_target = '15.0'
  s.osx.deployment_target = '12.0'

  s.swift_version = '5.0'

  s.source_files = 'cocoapods/Sources/APIVerveNationalDebt/**/*.swift'

  s.frameworks = 'Foundation'

  # APIResponse, APIVerveError and the request plumbing, shared by every APIVerve pod.
  s.dependency 'APIVerveCore', '~> 1.2'
end
