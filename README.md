# Winter Supplement Calculator

The Winter Supplement Calculator is a Java-based application designed to calculate winter supplement amounts based on various client eligibility criteria. It was developed for the IS21 Full Stack Developer Competition.

## Prerequisites

- Docker

## Installation

1. Clone the repository to your local machine:

   ```bash
   git clone https://github.com/A-dith-ya/winter-supplement-calculator.git
   cd winter-supplement-calculator
   ```

2. Build the Docker image

   ```bash
    docker build -t winter-supplement-calculator .
   ```

3. Run the Docker image passing the required MQTT topic ID as the TOPIC_ID environment variable

   ```bash
    docker run -e TOPIC_ID=<your_topic_id> winter-supplement-calculator
   ```

## Testing

1. Build the Test image

   ```bash
    docker build -f Dockerfile.test -t winter-supplement-test .
   ```

2. Run the Test

   ```bash
    docker run winter-supplement-test
   ```

## Environment Variables

1. **`TOPIC_ID`**: Specify the MQTT topic ID the application uses to communicate with the broker. Example:

   ```bash
    docker run -e TOPIC_ID=4fbf74f5-5e9d-40ca-b6a5-ea529a94ccb2 winter-supplement-calculator
   ```
## Design Choices

1. Strategy pattern: The rules engine encapsulates different eligibility criteria and calculations for the Winter Supplement Amounts, allowing for flexibility and scalability when adding changes or adding new rules without modifying existing logic.
2. Decision Table Testing: Validate the rules engine against various combinations of conditions (familyComposition, numberOfChildren, familyUnitInPayForDecember) to ensure accuracy, allowing for comprehensive coverage of the eligibility criteria.

## Assumptions

1. The app assumes an active MQTT broker is running at the specified topic ID.
2. The application assumes the number of children is capped at 30, representing a realistic edge case value.