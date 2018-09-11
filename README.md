# bx-cf-java-helloworld

A collection of simple Java projects (JEE and Spring) for pushing to Bluemix Cloud Foundary.

Push these to learn about Cloud Foundary and build packs.

## How to deploy:
Run `bx cf login` - provide your Bluemix login
Run `bx cf push` - the deploy uses manifest.yml

To deploy with a specific build pack:
`bx cf push -b https://github.com/barecode/ibm-websphere-liberty-buildpack.git`

