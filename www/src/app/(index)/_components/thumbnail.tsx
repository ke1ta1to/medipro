import Image from "next/image";

export function Thumbnail() {
  return (
    <div className="not-prose flex flex-col items-center">
      <Image
        alt="screenshot"
        src="/screenshot-1.png"
        width={2100}
        height={1334}
      />
    </div>
  );
}
