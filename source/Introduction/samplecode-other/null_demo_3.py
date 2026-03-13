import random
text = "hello"
if random.random() < 0.001:
    text = None
print(text.upper())
